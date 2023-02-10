package testss;

public class ClassTest {
    private int test1;
    private int test2;

    public ClassTest() {
    }


    public int getTest1() {
        return this.test1;
    }

    public void setTest1(int test1) {
        this.test1 = test1;
    }

    public int getTest2() {
        return this.test2;
    }

    public void setTest2(int test2) {
        this.test2 = test2;
    }

    public ClassTest(int test1, int test2) {
        this.test1 = test1;
        this.test2 = test2;
    }

    public ClassTest test1(int test1) {
        setTest1(test1);
        return this;
    }

    public ClassTest test2(int test2) {
        setTest2(test2);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClassTest)) {
            return false;
        }
        ClassTest classTest = (ClassTest) o;
        return test1 == classTest.test1 && test2 == classTest.test2;
    }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(test1, test2);
    // }

    @Override
    public String toString() {
        return "{" +
            " test1='" + getTest1() + "'" +
            ", test2='" + getTest2() + "'" +
            "}";
    }

}
