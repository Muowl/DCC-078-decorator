package padroes.decorator;

import java.math.BigDecimal;

public class FretePadrao implements Frete {
    @Override
    public BigDecimal getValor() {
        return new BigDecimal("20.00");
    }

    @Override
    public String getDescricao() {
        return "Frete padrão";
    }
}
