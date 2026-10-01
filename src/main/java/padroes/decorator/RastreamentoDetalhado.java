package padroes.decorator;

import java.math.BigDecimal;

public class RastreamentoDetalhado extends FreteDecorator {
    public RastreamentoDetalhado(Frete frete) {
        super(frete);
    }

    @Override
    protected BigDecimal getValorAdicional() {
        return new BigDecimal("3.00");
    }

    @Override
    protected String getServicoAdicional() {
        return "rastreamento detalhado";
    }
}
