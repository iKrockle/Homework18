public class Main {
    public static void main(String[] args) {

        String login = "java_skypro_go",password = "123",confirmPassword= "123";
        try {
            checkAuth(login, password, confirmPassword);
            System.out.println("Successful check");
        } catch (NullPointerException e){
            System.out.println("Some parameters is empty");
        } catch (WrongLoginException e){
            System.out.println("login contains wrong symbols or length more than 20");
        } catch (WrongPasswordException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Check done");
        }

    }
    static void checkAuth(String login,String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (password == null||password.isEmpty()
                ||login==null||login.isEmpty()||
                confirmPassword==null||confirmPassword.isEmpty()) {
            throw new NullPointerException();
        }

        if(!login.matches("^[a-zA-Z0-9_]{1,20}$")){
            throw new WrongLoginException();
        }

        if (!password.matches("^[a-zA-Z0-9_]{1,20}$")) {
            throw new WrongPasswordException("password contains wrong symbols or length more than 20");
        }

        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException("checking not match password");
        }
    }
}