package padroes.decorator;

import java.util.Locale;

public class CotadorFrete {
    public String gerarCotacao(Frete frete) {
        return String.format(new Locale("pt", "BR"), "%s: R$ %.2f",
                frete.getDescricao(), frete.getValor());
    }
}
