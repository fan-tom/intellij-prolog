// This is a generated file. Not intended for manual editing.
package tech.phosphorus.intellij.prolog.psi;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static tech.phosphorus.intellij.prolog.psi.PrologTypes.*;
import static tech.phosphorus.intellij.prolog.psi.PrologParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class PrologParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // primary
  public static boolean expr_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR_BODY, "<expr body>");
    r = primary(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // predicate
  public static boolean expr_head(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_head")) return false;
    if (!nextTokenIs(b, CONST_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = predicate(b, l + 1);
    exit_section_(b, m, EXPR_HEAD, r);
    return r;
  }

  /* ********************************************************** */
  // const_id | atom_id
  public static boolean ident(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ident")) return false;
    if (!nextTokenIs(b, "<ident>", ATOM_ID, CONST_ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENT, "<ident>");
    r = consumeToken(b, CONST_ID);
    if (!r) r = consumeToken(b, ATOM_ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ',' primary
  public static boolean logical_and(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_and")) return false;
    if (!nextTokenIs(b, COMMA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && primary(b, l + 1);
    exit_section_(b, m, LOGICAL_AND, r);
    return r;
  }

  /* ********************************************************** */
  // '/-' primary
  public static boolean logical_not(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_not")) return false;
    if (!nextTokenIs(b, NOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOT);
    r = r && primary(b, l + 1);
    exit_section_(b, m, LOGICAL_NOT, r);
    return r;
  }

  /* ********************************************************** */
  // ';' primary
  public static boolean logical_or(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_or")) return false;
    if (!nextTokenIs(b, SEMI)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMI);
    r = r && primary(b, l + 1);
    exit_section_(b, m, LOGICAL_OR, r);
    return r;
  }

  /* ********************************************************** */
  // '(' primary? ')'
  public static boolean parameter_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list")) return false;
    if (!nextTokenIs(b, LP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && parameter_list_1(b, l + 1);
    r = r && consumeToken(b, RP);
    exit_section_(b, m, PARAMETER_LIST, r);
    return r;
  }

  // primary?
  private static boolean parameter_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_1")) return false;
    primary(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // const_id parameter_list?
  public static boolean predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate")) return false;
    if (!nextTokenIs(b, CONST_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONST_ID);
    r = r && predicate_1(b, l + 1);
    exit_section_(b, m, PREDICATE, r);
    return r;
  }

  // parameter_list?
  private static boolean predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_1")) return false;
    parameter_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (predicate | logical_not | ident | operator_id) (predicate | logical_not | logical_and | logical_or | ident | operator_id)*
  static boolean primary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primary_0(b, l + 1);
    r = r && primary_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // predicate | logical_not | ident | operator_id
  private static boolean primary_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_0")) return false;
    boolean r;
    r = predicate(b, l + 1);
    if (!r) r = logical_not(b, l + 1);
    if (!r) r = ident(b, l + 1);
    if (!r) r = consumeToken(b, OPERATOR_ID);
    return r;
  }

  // (predicate | logical_not | logical_and | logical_or | ident | operator_id)*
  private static boolean primary_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!primary_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primary_1", c)) break;
    }
    return true;
  }

  // predicate | logical_not | logical_and | logical_or | ident | operator_id
  private static boolean primary_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_1_0")) return false;
    boolean r;
    r = predicate(b, l + 1);
    if (!r) r = logical_not(b, l + 1);
    if (!r) r = logical_and(b, l + 1);
    if (!r) r = logical_or(b, l + 1);
    if (!r) r = ident(b, l + 1);
    if (!r) r = consumeToken(b, OPERATOR_ID);
    return r;
  }

  /* ********************************************************** */
  // rule*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!rule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !<<eof>> expr_head (':-' expr_body)? '.'
  static boolean rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rule_0(b, l + 1);
    r = r && expr_head(b, l + 1);
    r = r && rule_2(b, l + 1);
    r = r && consumeToken(b, DOT);
    exit_section_(b, m, null, r);
    return r;
  }

  // !<<eof>>
  private static boolean rule_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (':-' expr_body)?
  private static boolean rule_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_2")) return false;
    rule_2_0(b, l + 1);
    return true;
  }

  // ':-' expr_body
  private static boolean rule_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNIFY);
    r = r && expr_body(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}