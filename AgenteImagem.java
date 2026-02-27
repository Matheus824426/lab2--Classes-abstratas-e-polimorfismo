public class AgenteImagem extends AgenteIA {

    public AgenteImagem(String nome) {
        super(nome);
    }

    @Override
    public void processarRequisicao(String input)
            throws FalhaProcessamentoAgenteException,
                   PromptInadequadoException,
                   ErroComunicacaoIAException {

        conectarServidor();

        String texto = input.toLowerCase();

        if (texto.contains("hackear") ||
            texto.contains("roubar") ||
            texto.contains("biométrico")) {

            throw new PromptInadequadoException("Violação de segurança detectada no prompt de imagem.");
        }

        System.out.println("Agente de Imagem [" + getNome() + "] sintetizando pixels para: [" + input + "]");
    }
}