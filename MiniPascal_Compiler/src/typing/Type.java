package typing;


public enum Type {
    INT_TYPE {
        public String toString() {
            return "Integer";
        }
    },
    REAL_TYPE {
        public String toString() {
            return "Real";
        }
    },
    BOOL_TYPE {
        public String toString() {
            return "Bool";
        }
    },
    STR_TYPE {
        public String toString() {
            return "String";
        }
    },
    CHAR_TYPE {
        public String toString() {
            return "Char";
        }
    },
    ARRAY_TYPE {
        public String toString() {
            return "array";
        }
    },
    NO_TYPE { // Indica um erro de tipos.
        public String toString() {
            return "no_type";
        }
    };
}
