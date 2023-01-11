package app.db;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class MyObjectOutputStream extends ObjectOutputStream {
    public MyObjectOutputStream() throws IOException {
        super();
    }

    public MyObjectOutputStream(OutputStream O) throws IOException {
        super(O);
    }

    public void writeStreamHeader() {
    }
}
