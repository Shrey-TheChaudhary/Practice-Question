class Solution {
    StringBuilder builder = new StringBuilder();
    Stack<Character> st = new Stack<>();
    public void append(char x) {
        // append x into document
        builder.append(x);
    }

    public void undo() {
        // undo last change
        st.push(builder.charAt(builder.length() - 1));
        builder.deleteCharAt(builder.length() - 1);
    }

    public void redo() {
        // redo changes
        if(st.isEmpty()) return;
        builder.append(st.pop());
    }

    public String read() {
        // read the document
        return builder.toString();
    }
}