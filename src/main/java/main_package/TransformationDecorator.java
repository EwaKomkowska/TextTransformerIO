package main_package;

/**
 * Abstract decorator class, which takes different transformations.
 */
public abstract class TransformationDecorator implements Transformation {
    private final Transformation decoratedTransformation;

    /**
     * Constructor of abstract transformation decorator.
     * @param t decorated transformation
     */
    public TransformationDecorator(Transformation t) {
        this.decoratedTransformation = t;
    }

    /**
     * Transforming function which takes text and index of transformation.
     * Runs function of actual decorated object.
     * @param text given string by user
     * @param index number of transformation
     * @return text after transformation
     */
    @Override
    public String transform(String text, int index) {
        return decoratedTransformation.transform(text, index);
    }
}
