package padroes.decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CotadorFreteTest {
    private final CotadorFrete cotador = new CotadorFrete();

    @Test
    void deveGerarCotacaoDoFretePadrao() {
        assertEquals("Frete padrão: R$ 20,00", cotador.gerarCotacao(new FretePadrao()));
    }

    @Test
    void deveGerarCotacaoComTodosOsServicos() {
        Frete frete = new EntregaExpressa(new RastreamentoDetalhado(new SeguroTransporte(new FretePadrao())));

        assertEquals("Frete padrão + seguro de transporte + rastreamento detalhado + entrega expressa: R$ 40,00",
                cotador.gerarCotacao(frete));
    }
}
