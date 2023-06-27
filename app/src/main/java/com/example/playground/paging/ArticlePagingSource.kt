package com.example.playground.paging

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.playground.paging.entity.Article
import java.lang.Integer.max
import java.time.LocalDateTime
import kotlinx.coroutines.delay

class ArticlePagingSource : PagingSource<Int, Article>() {

    @RequiresApi(Build.VERSION_CODES.O)
    private val firstArticleCreatedTime = LocalDateTime.now()

    /**
     * A função load() vai ser chamada pela biblioteca Paging para buscar de forma assíncrona mais dados que serão exibidos à medida que o
     * usuário rolar a tela. O objeto LoadParams mantém as informações relacionadas à operação de carregamento, incluindo o seguinte:
     *
     * A chave da página a ser carregada: se for a primeira vez que a função load() é chamada, LoadParams.key vai ser null. Nesse caso, será necessário definir a chave da página inicial. Para o nosso projeto, usamos o ID do artigo como a chave. Também vamos adicionar uma constante STARTING_KEY de 0 à parte de cima do arquivo ArticlePagingSource para a chave de página inicial.
     * Tamanho do carregamento: o número de itens solicitados a serem carregados.
     */
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        // Start paging with the STARTING_KEY if this is the first load
        val start = params.key ?: STARTING_KEY

        // Load as many items as hinted by params.loadSize
        val range = start.until(start + params.loadSize)

        if (start != STARTING_KEY) delay(LOAD_DELAY_MILLIS)

        return LoadResult.Page(
            data = range.map { number ->
                // Generate consecutive increasing numbers as the article id
                Article(
                    id = number,
                    title = "Article $number",
                    description = "This describes article $number",
                    created = firstArticleCreatedTime.minusDays(number.toLong())
                )
            },

            // Make sure we don't try to load items behind the STARTING_KEY
            prevKey = when (start) {
                STARTING_KEY -> null
                else -> ensureValidKey(key = range.first - params.loadSize)
            },
            nextKey = range.last + 1
        )
    }

    // The refresh key is used for the initial load of the next PagingSource, after invalidation
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        // In our case we grab the item closest to the anchor position
        // then return its id - (state.config.pageSize / 2) as a buffer
        val anchorPosition = state.anchorPosition ?: return null
        val article = state.closestItemToPosition(anchorPosition) ?: return null
        return ensureValidKey(key = article.id - (state.config.pageSize / 2))
    }

    /**
     * Makes sure the paging key is never less than [STARTING_KEY]
     */
    private fun ensureValidKey(key: Int) = max(STARTING_KEY, key)

    private companion object {
        const val STARTING_KEY = 0
        const val LOAD_DELAY_MILLIS = 3_000L
    }
}