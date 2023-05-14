package solid.singleresponsibility;

/**
 * There should never be more than one reason for a class to change.
 * So this class provides a very focused functionality, single functionality,
 * or it addresses a specific concern of our desired functionality.
 * e.g. lets say that we have written in a single class and that
     * code is actually creating and sending a message to remote server that is listening on
     * some port.
 * Now what are the possible reasons for this particular class to change?
 *  Since we have done a lot more in single class, there are multiple reasons here:
 *      Let's say the communication protocol changes, then our class needs to change.
 *      Let's say the message format changes, for example let's say we were sending our message
 *          in a JSON format and suddenly server said, ok we are only going to accept only XML
 *          messages now. So our class again needs to change.
 *      The other reason could be that the parameters of communication, for example, authentication
 *          is added as a measure of security, so again our class needs to change.
 * And this is what we should avoid. This is what our single responsibility principle is saying to avoid it.
 * It basically says that of we have three separate responsibilities, then we should have three separate classes or
     * modules to handle those responsibilities and that whenever something changes, our code can be changed in an
     * organized manner.
 * So this principle means that whenever you're designing a class or a module, you should take care,
 *  that, that particular class is addressing only a specific concern so that when time comes or a change comes down
 *  the pipeline, then there is only one reason for a particular class to change.
 */
public interface SingleResponsibility {
}
