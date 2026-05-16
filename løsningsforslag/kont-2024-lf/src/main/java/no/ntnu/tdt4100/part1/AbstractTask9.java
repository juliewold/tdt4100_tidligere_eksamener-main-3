package no.ntnu.tdt4100.part1;

/**
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 */
public abstract class AbstractTask9 {
    public int[] checkboxes = new int[6];

    public void Polymorphism_cannot_be_achieved_with_inheritance() {
        checkboxes[0] = 1;
    }

    public void A_superclass_constructor_is_always_called_when_a_subclass_is_instantiated() {
        checkboxes[1] = 1;
    }

    public void Subclasses_cannot_override_methods_defined_in_their_superclasses() {
        checkboxes[2] = 1;
    }

    public void Abstract_classes_cannot_have_constructors() {
        checkboxes[3] = 1;
    }

    public void A_subclass_cannot_access_any_private_fields_of_its_superclass_directly() {
        checkboxes[4] = 1;
    }

    public void A_class_can_extend_multiple_classes_in_Java() {
        checkboxes[5] = 1;
    }

}