/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.files;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/**
 *
 * @author Miguel
 */
public class TestPathMatcher {

    public static void main(String[] args) {
/*
supports the "glob" and "regex" 
        glob
Ejempl
*.java	Matches a path that represents a file name ending in .java
*.*	Matches file names containing a dot
*.{java,class}	Matches file names ending with .java or .class
foo.?	Matches file names starting with foo. and a single character extension
/home/**	Matches /home/gus and /home/gus/data on UNIX platforms
C:\\*	Matches C:\foo and C:\bar, (backslash is escaped, pattern would be "C:\\\\*")
        Rules:
The * character matches zero or more characters of a name component without crossing directory boundaries.
The ** characters matches zero or more characters crossing directory boundaries.
The ? character matches exactly one character of a name component.
The backslash character (\) is used to escape characters that would otherwise be interpreted as special characters. The expression \\ matches a single backslash and "\{" matches a left brace for example.
The [ ] match a single character of a name component out of a set of characters. For example, [abc] matches "a", "b", or "c". 
    The hyphen (-) may be used to specify a range so [a-z] specifies a range that matches from "a" to "z" (inclusive).
    If the character after the [ is a ! then it is used for negation so [!a-c] matches any character except "a", "b", or "c".
Within a bracket expression the *, ? and \ characters match themselves. The (-) character matches itself if it is the first character within the brackets, or the first character after the ! if negating.
The { } characters are a group of subpatterns, where the group matches if any subpattern in the group matches. The "," character is used to separate the subpatterns. Groups cannot be nested.
Leading period/dot characters in file name are treated as regular characters in match operations. For example, the "*" glob pattern matches file name ".login". The Files.isHidden(java.nio.file.Path) method may be used to test whether a file is considered hidden.
All other characters match themselves in an implementation dependent manner. This includes characters representing any name-separators.
The matching of root components is highly implementation-dependent and is not specified.
*/
    
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/testFile.?");
        
        Path path = Paths.get("D:/cp/testFile.t");
        //unico metodo
        System.out.println(pathMatcher.matches(path));//true
    }

}
