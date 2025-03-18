package com.example.BookShelf.util.validator;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class HexCodeMapper {

    private final Set<Character> allowedChars = new HashSet<Character>();
    private final int allowedLength = 7;

    public HexCodeMapper()
    {
        var chars = "1234567890ABCDEF";
        for (char c: chars.toCharArray())
        {
            allowedChars.add(c);
        }
    }

    public String mapHexCode(String hexCode) throws Exception {
        hexCode = hexCode.toUpperCase();
        if (hexCode.length() != 7) throw new Exception("Wrong Code! Inappropriate length");
        for (char c: hexCode.substring(1).toCharArray())
        {
            if (!allowedChars.contains(c)) throw new Exception(String.format("Wrong Code! Inappropriate letter: %c", c));
        }
        return hexCode;
    }
}
