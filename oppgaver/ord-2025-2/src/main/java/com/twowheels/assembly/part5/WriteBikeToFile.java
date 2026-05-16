package com.twowheels.assembly.part5;

import no.ntnu.tdt4100.twowheels.*;

// TODO: Import relevant libraries

 import java.io.IOException;
 import java.io.OutputStream;
 import java.util.Map;

public class WriteBikeToFile {

    /**
     * Writes the details of a {@link no.ntnu.tdt4100.twowheels.ICustomBuild} to the provided
     * {@link OutputStream}.
     * 
     * The method generates a string representation of the custom bike build, including 
     * the customer name and phone, a list of bike components with quantity, name, manufacturer and unit price,
     * and the total price for this build.
     * 
     * Each attribute is separated by a semicolon, and each section
     * (customer info, bike components, total price) is separated by a blank line.
     * The generated string is then written to the provided OutputStream.
     * 
     * The format of the output should be as follows:
     * 
     * <pre>
     * customername;customerphone
     * 
     * quantity1;componentname1;manufacturer1;unitprice1
     * quantity2;componentname2;manufacturer2;unitprice2
     * quantity3;componentname3;manufacturer3;unitprice3
     * 
     * totalprice
     * </pre>
     * 
     * The file resources/output_example.txt contains an example of how the output
     * should look.
     * 
     * @param build        The {@link ICustomBuild} object whose details are to be
     *                     written. You can assume that this object will not be
     *                     null.
     * @param outputStream The {@link OutputStream} to which the bike build details
     *                     to be written.
     * @throws IOException If an I/O error occurs when writing to the stream.
     * 
     * @see ICustomBuild
     * @see Customer
     * @see IBikeComponents
     * @see BikeComponents
     */

    public static void write(ICustomBuild build, OutputStream outputStream) throws IOException {
        
        // TODO: Complete the method according to JavaDoc

        String output = "";

        Customer customer = build.getCustomer();

        output += customer.name() + ";" + customer.phone() + "\n\n";

        Map<IBikeComponent, Integer> itemMap = build.getComponents();

        for (Map.Entry<IBikeComponent, Integer> entry : itemMap.entrySet()) {

            BikeComponent component = (BikeComponent)entry.getKey();
            Integer quantity = entry.getValue();

            output += quantity + ";" + 
                component.getComponentName() + ";" + 
                component.getManufacturer() + ";" + 
                component.getPrice() + "\n";
        }

        output += "\n" + build.getTotalPrice() + "\n";

        output += "\n";
        
        outputStream.write(output.getBytes());
        outputStream.flush();
    }

}
