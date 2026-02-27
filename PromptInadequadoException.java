import java.time.LocalDateTime;

public class PromptInadequadoException extends Exception {
    private String timestamp;

    public PromptInadequadoException(String mensagem) {
        super(mensagem);
        this.timestamp = LocalDateTime.now().toString();
    }

    public String getTimestamp() {
        return timestamp;
    }
}