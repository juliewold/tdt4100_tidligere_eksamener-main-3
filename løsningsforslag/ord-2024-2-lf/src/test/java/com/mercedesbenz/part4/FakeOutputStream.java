package com.mercedesbenz.part4;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FakeOutputStream extends OutputStream {
    private List<Integer> bytes = new ArrayList<>();

    public FakeOutputStream() {
    }

    @Override
    public void write(int b) throws IOException {
        bytes.add(b);
    }

    public String getWrittenString() {
        byte[] byteArray = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            byteArray[i] = bytes.get(i).byteValue();
        }
        return new String(byteArray);
    }
}
