package padroes.decorator;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FreteTest {
    @Test
    void deveCotarFretePadrao() {
        verificarFrete(new FretePadrao(), "20.00", "Frete padrão");
    }

    @Test
    void deveAcrescentarSeguro() {
        verificarFrete(new SeguroTransporte(new FretePadrao()), "25.00",
                "Frete padrão + seguro de transporte");
    }

    @Test
    void deveAcrescentarRastreamento() {
        verificarFrete(new RastreamentoDetalhado(new FretePadrao()), "23.00",
                "Frete padrão + rastreamento detalhado");
    }

    @Test
    void deveAcrescentarEntregaExpressa() {
        verificarFrete(new EntregaExpressa(new FretePadrao()), "32.00",
                "Frete padrão + entrega expressa");
    }

    @Test
    void deveCombinarSeguroERastreamento() {
        Frete frete = new RastreamentoDetalhado(new SeguroTransporte(new FretePadrao()));
        verificarFrete(frete, "28.00", "Frete padrão + seguro de transporte + rastreamento detalhado");
    }

    @Test
    void deveCombinarSeguroEEntregaExpressa() {
        Frete frete = new EntregaExpressa(new SeguroTransporte(new FretePadrao()));
        verificarFrete(frete, "37.00", "Frete padrão + seguro de transporte + entrega expressa");
    }

    @Test
    void deveCombinarRastreamentoEEntregaExpressa() {
        Frete frete = new EntregaExpressa(new RastreamentoDetalhado(new FretePadrao()));
        verificarFrete(frete, "35.00", "Frete padrão + rastreamento detalhado + entrega expressa");
    }

    @Test
    void deveCombinarTodosOsServicos() {
        Frete frete = new EntregaExpressa(new RastreamentoDetalhado(new SeguroTransporte(new FretePadrao())));
        verificarFrete(frete, "40.00",
                "Frete padrão + seguro de transporte + rastreamento detalhado + entrega expressa");
    }

    @Test
    void devePermitirOutraOrdemDeComposicao() {
        Frete frete = new SeguroTransporte(new EntregaExpressa(new RastreamentoDetalhado(new FretePadrao())));
        verificarFrete(frete, "40.00",
                "Frete padrão + rastreamento detalhado + entrega expressa + seguro de transporte");
    }

    @Test
    void devePreservarFreteOriginalAoCriarCotacoesDiferentes() {
        Frete original = new FretePadrao();
        Frete segurado = new SeguroTransporte(original);
        Frete expresso = new EntregaExpressa(original);

        verificarFrete(original, "20.00", "Frete padrão");
        verificarFrete(segurado, "25.00", "Frete padrão + seguro de transporte");
        verificarFrete(expresso, "32.00", "Frete padrão + entrega expressa");
    }

    @Test
    void deveRecusarServicoSemFrete() {
        assertAll(
                () -> assertThrows(NullPointerException.class, () -> new SeguroTransporte(null)),
                () -> assertThrows(NullPointerException.class, () -> new RastreamentoDetalhado(null)),
                () -> assertThrows(NullPointerException.class, () -> new EntregaExpressa(null)));
    }

    private void verificarFrete(Frete frete, String valor, String descricao) {
        assertAll(
                () -> assertEquals(new BigDecimal(valor), frete.getValor()),
                () -> assertEquals(descricao, frete.getDescricao()));
    }
}
