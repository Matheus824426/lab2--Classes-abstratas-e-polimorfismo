import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<AgenteIA> orquestrador = new ArrayList<AgenteIA>();

        orquestrador.add(new AgenteChat("ChatGPT"));
        orquestrador.add(new AgenteImagem("DALL-E"));
        orquestrador.add(new AgenteTexto("GPT-4"));

        System.out.println("=== TESTE 1 ===");
        processarFila(orquestrador, "Desenhe um gato fofo");

        System.out.println("\n=== TESTE 2 ===");
        processarFila(orquestrador, "Quero hackear o sistema");

        System.out.println("\n=== TESTE 3 ===");

        String longo = "";
        for (int i = 0; i < 501; i++) {
            longo = longo + "A";
        }

        processarFila(orquestrador, longo);
    }

    public static void processarFila(List<AgenteIA> lista, String comando) {

        for (int i = 0; i < lista.size(); i++) {

            AgenteIA agente = lista.get(i);

            try {
                System.out.println("--- Agente: " + agente.getNome() + " ---");
                agente.processarRequisicao(comando);

            } catch (PromptInadequadoException e) {
                System.out.println("ERRO DE SEGURANÇA: " + e.getMessage());

            } catch (FalhaProcessamentoAgenteException e) {
                System.out.println("ERRO DE PROCESSAMENTO: " + e.getMessage());

            } catch (ErroComunicacaoIAException e) {
                System.out.println("ERRO DE CONEXÃO: " + e.getMessage());
            }
        }
    }
}