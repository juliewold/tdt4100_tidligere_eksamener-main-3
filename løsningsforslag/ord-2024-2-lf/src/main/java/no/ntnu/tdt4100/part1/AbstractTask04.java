package no.ntnu.tdt4100.part1;

/**
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 */
public abstract class AbstractTask04 {
    public int[] checkboxes = new int[6];

    public void A_class_cannot_be_instantiated_outside_its_package_unless_it_has_a_public_modifier() { checkboxes[0] = 1; }
    public void A_class_can_extend_multiple_classes() { checkboxes[1] = 1; }
    public void An_abstract_class_must_include_at_least_1_abstract_method() { checkboxes[2] = 1; }
    public void The_Override_annotation_must_be_used_when_overriding_methods_from_parent_classes() { checkboxes[3] = 1; }
    public void If_a_superclass_has_a_declared_constructor_a_subclass_must_also_declare_a_constructor() { checkboxes[4] = 1; }
    public void A_class_can_implement_only_one_interface() { checkboxes[5] = 1;}
}