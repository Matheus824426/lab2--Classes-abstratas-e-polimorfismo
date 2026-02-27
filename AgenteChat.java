public class AgenteChat extends AgenteIA {

    public AgenteChat(String nome) {
        super(nome);
    }

    @Override
    public void processarRequisicao(String input)
            throws FalhaProcessamentoAgenteException,
                   PromptInadequadoException,
                   ErroComunicacaoIAException {

        conectarServidor();

        if (input.toLowerCase().contains("ofensivo")) {
            throw new PromptInadequadoException("Conteúdo ofensivo detectado.");
        }

        System.out.println("Agente Chat [" + getNome() + "] respondendo conversa: [" + input + "]");
    }
}