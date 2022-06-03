public class AcceptMessage {

    private boolean accept;
    private String message;

    public AcceptMessage(boolean accept, String message) {
        this.accept = accept;
        this.message = message;
    }

    public AcceptMessage(boolean accept) {
        this.accept = accept;
        this.message = "";
    }

    public String getMessage() {
        return message;
    }

    public boolean isAccept() {
        return accept;
    }
}
