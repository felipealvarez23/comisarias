package co.com.efalvare.model.exeption;

public class OrchestratorException extends ApiError{
    private static final String TITLE = "Orchestrator exception";
    public OrchestratorException(String code, String description) {
        super(TITLE, code, description);
    }
}
