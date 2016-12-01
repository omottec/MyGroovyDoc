/**
 * Created by qinbingbing on 12/1/16.
 */

class Enclosing {
    void run() {
        def whatIsOwnerMethod = { getOwner() }
        assert whatIsOwnerMethod == this
    }
}