package shop.btwo.resq;

/**
 * @author bangbang
 * @create 2023-04-10-0:51
 */
public class CommonFalse {
    private boolean error = true;

    @Override
    public String toString() {
        return "CommonFalse{" +
                "error=" + error +
                '}';
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
