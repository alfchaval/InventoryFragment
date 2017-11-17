package com.example.usuario.inventory.ui.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by usuario on 11/13/17.
 */

public final class CommonUtils {

    /**
     * Método que comprueba que la contraseña tenga los siguientes requisitos
     * Debe contener al menos un dígito 0-9
     * Debe contener al menos un carácter en mayúscula
     * Debe contener al menos un carácter en minúscula
     * Debe tener una longitud de al menos seis caracteres
     * @param password
     * @return
     */
    public static boolean isPasswordValid(String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }
}
