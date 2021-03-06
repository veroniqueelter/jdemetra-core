/*
* Copyright 2013 National Bank of Belgium
*
* Licensed under the EUPL, Version 1.1 or – as soon they will be approved 
* by the European Commission - subsequent versions of the EUPL (the "Licence");
* You may not use this work except in compliance with the Licence.
* You may obtain a copy of the Licence at:
*
* http://ec.europa.eu/idabc/eupl
*
* Unless required by applicable law or agreed to in writing, software 
* distributed under the Licence is distributed on an "AS IS" basis,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the Licence for the specific language governing permissions and 
* limitations under the Licence.
*/

package ec.benchmarking;

import ec.tstoolkit.data.DataBlock;
import ec.tstoolkit.design.Development;

/**
 *
 * @author Jean Palate
 */
@Development(status = Development.Status.Alpha)
public class Cumulator {

    private int n_;

    /**
     * 
     * @param n
     */
    public Cumulator(int n) {
        n_ = n;
    }

    /**
     * 
     * @param data
     */
    public void transform(DataBlock data) {
        int pos = 0;
        for (int i = pos, j = 0; i < data.getLength(); ++i) {
            if (j++ > 0) {
                data.add(i, data.get(i - 1));
                if (j == n_) {
                    j = 0;
                }
            }
        }
    }

    /**
     * 
     * @param data
     */
    public void transform(double[] data) {
        int pos = 0;
        for (int i = pos, j = 0; i < data.length; ++i) {
            if (j++ > 0) {
                data[i] += data[i - 1];
                if (j == n_) {
                    j = 0;
                }
            }
        }
    }
}
