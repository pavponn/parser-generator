import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import parser.regex.RegexParser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

/**
 * @author pavponn
 */
@RunWith(DataProviderRunner.class)
public class RegexParserTest {

    @DataProvider
    public static Object[][] correctInputRegexData() {
        return new Object[][] {
                {"a"}, {"rzdef"}, {"ab"}, {"abc"},{"devcldofgh"}, {"ab(cde)fg"},
                {"a|b"}, {"defg|a"}, {"xyz|rd    eqa*"}, {"a|(type|theory)"}, {"a|b|c|d|e|klmno"},
                {"a*"}, {"tra(nsla(tio(n)*)*)*|(m)*e|t(o)ds*"}, {"ma((c*|d)ef*)"}, {"ma(cs|do)*rs"}, {"aa*|bb*|cdefgh"}
        };
    }

    @DataProvider
    public static Object[][] incorrectInputRegexData() {
        return new Object[][] {
                {"a231"}, {"RZDEF22"}, {"ab)"}, {")de(vcldofgh"}, {"abcde)fg"},
                {"ab232"}, {"defg|a   203|"}, {"xyz|R D E F * LDWQ"},
                {"*a"}, {"tra*|*n*SlaTion|meThOdS*"}, {"ma(c*|*def*)"}, {"m*a(c(s)|)do)*rs"}, {"aa*|bb*|cde21fgh"},
                {"(((((dddd)))))))))"}
        };
    }

    @Test
    public void shouldAcceptSampleInput() throws ParseException {
        InputStream stream = new ByteArrayInputStream("((abc*b|a)*ab(aa|b*)b)*".getBytes(StandardCharsets.UTF_8));
        new RegexParser().parse(stream);
    }

    @Test
    @DataProvider({"aa", "abcdef", "ad edg w", "ll", "rzpx asdo  dsd"})
    public void shouldAcceptConcatenation(String regex) throws ParseException {
        InputStream stream = new ByteArrayInputStream(regex.getBytes(StandardCharsets.UTF_8));
        new RegexParser().parse(stream);
    }

    @Test
    @DataProvider({"(aa)", "(a) (a) (ddds)", "((a))((ad)(xx))", "(s()(a)a)"})
    public void shouldAcceptGroup(String regex) throws ParseException {
        InputStream stream = new ByteArrayInputStream(regex.getBytes(StandardCharsets.UTF_8));
        new RegexParser().parse(stream);
    }

    @Test
    @DataProvider({"a|a", "d|", "|a", "|c|",  "(e|dg) w| (u| ) zzz", "x(z(d|a)| x)a", "(rzpx) a|sdo d(s|d)"})
    public void shouldAcceptRegexWithBar(String regex) throws ParseException {
        InputStream stream = new ByteArrayInputStream(regex.getBytes(StandardCharsets.UTF_8));
        new RegexParser().parse(stream);
    }

    @Test
    @DataProvider({"a*", "(ac)*", "(()*)*", "aa*", "(cvd*)*", "a*a(|aa*)*a|a*(aa*)", "(a*a*(cd*zz*)a*a*)*"})
    public void shouldAcceptRegexWithStar(String regex) throws ParseException {
        InputStream stream = new ByteArrayInputStream(regex.getBytes(StandardCharsets.UTF_8));
        new RegexParser().parse(stream);
    }


    @Test(expected = ParseException.class)
    @UseDataProvider("incorrectInputRegexData")
    public void shouldNotAcceptIncorrectRegularExpression(String incorrectRegex) throws ParseException {
        InputStream stream = new ByteArrayInputStream(incorrectRegex.getBytes(StandardCharsets.UTF_8));
        new RegexParser().parse(stream);
    }

    @Test
    @UseDataProvider("correctInputRegexData")
    public void shouldAcceptCorrectRegularExpression(String correctRegex) throws ParseException {
        InputStream stream = new ByteArrayInputStream(correctRegex.getBytes(StandardCharsets.UTF_8));
        new RegexParser().parse(stream);
    }

}
