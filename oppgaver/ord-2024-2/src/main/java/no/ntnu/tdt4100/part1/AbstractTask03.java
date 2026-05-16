package no.ntnu.tdt4100.part1;

/**
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 */
public abstract class AbstractTask03 {
    public abstract int magic(int number);

    public int[] checkboxes = new int[5];
    public void A_magic_will_return_0_given_it_is_invoked_with_param_5() {checkboxes[0] = 1;}
    public void B_magic_will_return_19_given_it_is_invoked_with_param_5() {checkboxes[1] = 1;}
    public void C_magic_will_return_20_given_it_is_invoked_with_param_5() {checkboxes[2] = 1;}
    public void D_magic_will_return_22_given_it_is_invoked_with_param_5() {checkboxes[3] = 1;}
    public void E_magic_will_return_99_given_it_is_invoked_with_param_5() {checkboxes[4] = 1;}
}
