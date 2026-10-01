package padroes.decorator;

import java.math.BigDecimal;

public class EntregaExpressa extends FreteDecorator {
    public EntregaExpressa(Frete frete) {
        super(frete);
    }

    @Override
    protected BigDecimal getValorAdicional() {
        return new BigDecimal("12.00");
    }

    @Override
    protected String getServicoAdicional() {
        return "entrega expressa";
    }
}
