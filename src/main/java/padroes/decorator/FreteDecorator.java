package padroes.decorator;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class FreteDecorator implements Frete {
    private final Frete frete;

    protected FreteDecorator(Frete frete) {
        this.frete = Objects.requireNonNull(frete, "Frete obrigatório");
    }

    @Override
    public BigDecimal getValor() {
        return frete.getValor().add(getValorAdicional());
    }

    @Override
    public String getDescricao() {
        return frete.getDescricao() + " + " + getServicoAdicional();
    }

    protected abstract BigDecimal getValorAdicional();

    protected abstract String getServicoAdicional();
}
