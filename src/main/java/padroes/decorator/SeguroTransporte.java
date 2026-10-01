package padroes.decorator;

import java.math.BigDecimal;

public class SeguroTransporte extends FreteDecorator {
    public SeguroTransporte(Frete frete) {
        super(frete);
    }

    @Override
    protected BigDecimal getValorAdicional() {
        return new BigDecimal("5.00");
    }

    @Override
    protected String getServicoAdicional() {
        return "seguro de transporte";
    }
}
