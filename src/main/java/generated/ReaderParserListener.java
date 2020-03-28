// Generated from /Users/pavel/ITMO/translation-methods/parsers-generator/src/main/java/ReaderParser.g4 by ANTLR 4.7.2
package generated;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ReaderParserParser}.
 */
public interface ReaderParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ReaderParserParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ReaderParserParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReaderParserParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ReaderParserParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReaderParserParser#parseInput}.
	 * @param ctx the parse tree
	 */
	void enterParseInput(ReaderParserParser.ParseInputContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReaderParserParser#parseInput}.
	 * @param ctx the parse tree
	 */
	void exitParseInput(ReaderParserParser.ParseInputContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReaderParserParser#inh}.
	 * @param ctx the parse tree
	 */
	void enterInh(ReaderParserParser.InhContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReaderParserParser#inh}.
	 * @param ctx the parse tree
	 */
	void exitInh(ReaderParserParser.InhContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReaderParserParser#synth}.
	 * @param ctx the parse tree
	 */
	void enterSynth(ReaderParserParser.SynthContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReaderParserParser#synth}.
	 * @param ctx the parse tree
	 */
	void exitSynth(ReaderParserParser.SynthContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReaderParserParser#varDescription}.
	 * @param ctx the parse tree
	 */
	void enterVarDescription(ReaderParserParser.VarDescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReaderParserParser#varDescription}.
	 * @param ctx the parse tree
	 */
	void exitVarDescription(ReaderParserParser.VarDescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReaderParserParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(ReaderParserParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReaderParserParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(ReaderParserParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReaderParserParser#nonTerminalName}.
	 * @param ctx the parse tree
	 */
	void enterNonTerminalName(ReaderParserParser.NonTerminalNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReaderParserParser#nonTerminalName}.
	 * @param ctx the parse tree
	 */
	void exitNonTerminalName(ReaderParserParser.NonTerminalNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReaderParserParser#terminalName}.
	 * @param ctx the parse tree
	 */
	void enterTerminalName(ReaderParserParser.TerminalNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReaderParserParser#terminalName}.
	 * @param ctx the parse tree
	 */
	void exitTerminalName(ReaderParserParser.TerminalNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReaderParserParser#terminalDescription}.
	 * @param ctx the parse tree
	 */
	void enterTerminalDescription(ReaderParserParser.TerminalDescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReaderParserParser#terminalDescription}.
	 * @param ctx the parse tree
	 */
	void exitTerminalDescription(ReaderParserParser.TerminalDescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReaderParserParser#cases}.
	 * @param ctx the parse tree
	 */
	void enterCases(ReaderParserParser.CasesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReaderParserParser#cases}.
	 * @param ctx the parse tree
	 */
	void exitCases(ReaderParserParser.CasesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReaderParserParser#exprs}.
	 * @param ctx the parse tree
	 */
	void enterExprs(ReaderParserParser.ExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReaderParserParser#exprs}.
	 * @param ctx the parse tree
	 */
	void exitExprs(ReaderParserParser.ExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReaderParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ReaderParserParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReaderParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ReaderParserParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReaderParserParser#variableNames}.
	 * @param ctx the parse tree
	 */
	void enterVariableNames(ReaderParserParser.VariableNamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReaderParserParser#variableNames}.
	 * @param ctx the parse tree
	 */
	void exitVariableNames(ReaderParserParser.VariableNamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReaderParserParser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(ReaderParserParser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReaderParserParser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(ReaderParserParser.VariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReaderParserParser#terminal}.
	 * @param ctx the parse tree
	 */
	void enterTerminal(ReaderParserParser.TerminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReaderParserParser#terminal}.
	 * @param ctx the parse tree
	 */
	void exitTerminal(ReaderParserParser.TerminalContext ctx);
}