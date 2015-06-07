/*
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package org.collectd.genericjmx;

import org.collectd.api.Collectd;
import org.collectd.api.OConfigItem;
import org.collectd.java.GenericJMX;

/**
 * @author philippefichet
 * @see https://developer.jboss.org/message/904415#904415
 */
public class GenericJMXWildfly  extends GenericJMX {
    public GenericJMXWildfly() {
        super();
        Collectd.registerConfig("GenericJMXWildfly", this);
        Collectd.registerRead("GenericJMXWildfly", this);
        Collectd.registerShutdown("GenericJMXWildfly", this);
        setClassLoader();
    }
 
    @Override
    public int config(OConfigItem ci) {
        setClassLoader();
        return super.config(ci);
    }
 
    @Override
    public int read() {
        setClassLoader();
        return super.read();
    }
 
    private void setClassLoader() {
        Thread.currentThread().setContextClassLoader(ClassLoader.getSystemClassLoader());
    }
}
