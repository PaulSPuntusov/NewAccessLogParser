public class StringLengthCheck {
    int length;

    public StringLengthCheck(int length) {
        this.length = length;
    }
    public void stringLengthCheck(int length){
        if(length > 1024) throw new RuntimeException("must be less than 1024characters");
    }
}
