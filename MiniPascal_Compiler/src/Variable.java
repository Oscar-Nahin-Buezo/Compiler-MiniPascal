import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Variable {
    private Object value;

    public Variable(Object value) {
        setValue(value);
    }

    public void setValue(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("El valor no puede ser nulo");
        }
        if (!value.getClass().equals(this.value.getClass())) {
            throw new IllegalArgumentException("El tipo de dato no coincide");
        }
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public String getType() {
        return value.getClass().getSimpleName();
    }

    public long getSizeInBytes() {
        return sizeOf(value);
    }

    private static long sizeOf(Object object) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            oos.close();
            return baos.size();
        } catch ( IOException e) {
            throw new RuntimeException(e);
        }
    }
}
