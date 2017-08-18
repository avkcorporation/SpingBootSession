package ua.avk.shopbuilder.enums;


public enum EnumUserStatus {

    ALL {
        @Override
        public String toString() {
            return "Все пользователи";
        }

        public String toStringEn() {
            return "All users";
        }
    },

    ACTIVE {
        @Override
        public String toString() {
            return "Активные пользователи";
        }

        public String toStringEn() {
            return "Active users";
        }
    },

    INACTIVE {
        @Override
        public String toString() {
            return "Блокированные пользователи";
        }

        public String toStringEn() {
            return "Lock users";
        }

    },
    REGISTRATION {
        @Override
        public String toString() {
            return "Ждущие регистрацию";
        }

        public String toStringEn() {
            return "waiting for registration";
        }
    },
    DELETE {
        @Override
        public String toString() {
            return "Удалённые";
        }

        public String toStringEn() {
            return "Deleted";
        }
    };

    public abstract String toStringEn();

}