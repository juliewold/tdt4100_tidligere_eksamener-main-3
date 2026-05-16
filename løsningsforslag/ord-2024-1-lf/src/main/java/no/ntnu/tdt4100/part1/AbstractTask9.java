package no.ntnu.tdt4100.part1;

public abstract class AbstractTask9 {
    public int[] checkboxes = new int[6];

    public void A_constructor_has_no_declared_return_type() { checkboxes[0] = 1; }
    public void Its_name_must_be_the_same_as_the_class_in_which_it_is_defined() { checkboxes[1] = 1; }
    public void There_must_be_exactly_one_constructor_defined_for_a_class() { checkboxes[2] = 1; }
    public void Constructors_are_always_declared_as_public() { checkboxes[3] = 1; }
    public void They_can_appear_anywhere_in_the_class_where_it_is_legal_to_declare_a_method() { checkboxes[4] = 1; }
    public void Every_class_has_a_parameterless_default_constructor_if_no_other_constructors_are_defined() { checkboxes[5] = 1;}
}
