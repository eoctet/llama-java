package chat.octet.model.parameters;

import chat.octet.model.components.criteria.StoppingCriteriaList;
import chat.octet.model.components.processor.LogitsProcessorList;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.Nullable;


/**
 * <p>Generate parameter</p>
 * For more information, please refer to
 * <a href="https://github.com/ggerganov/llama.cpp/blob/master/examples/main/README.md">Llama.cpp docs</a>
 * and
 * <a href="https://huggingface.co/docs/transformers/main_classes/text_generation#transformers.GenerationConfig">Transformers docs</a>.
 *
 * @author <a href="https://github.com/eoctet">William</a>
 */
@Getter
@Builder
@ToString
public final class GenerateParameter {

    /**
     * <b>temperature</b><br/>
     * Adjust the randomness of the generated text (default: 0.8).
     */
    @Builder.Default
    private float temperature = 0.8f;

    /**
     * <b>repeat-penalty</b><br/>
     * Control the repetition of token sequences in the generated text (default: 1.1).
     */
    @Builder.Default
    private float repeatPenalty = 1.1f;

    /**
     * <b>no-penalize-nl</b><br/>
     * Disable penalization for newline tokens when applying the repeat penalty
     */
    @Builder.Default
    private boolean penalizeNl = true;

    /**
     * <b>frequency-penalty</b><br/>
     * Repeat alpha frequency penalty (default: 0.0, 0.0 = disabled)
     */
    @Builder.Default
    private float frequencyPenalty = 0.0f;

    /**
     * <b>presence-penalty</b><br/>
     * Repeat alpha presence penalty (default: 0.0, 0.0 = disabled)")
     */
    @Builder.Default
    private float presencePenalty = 0.0f;

    /**
     * <b>TOP-K Sampling</b><br/>
     * Limit the next token selection to the K most probable tokens (default: 40).
     */
    @Builder.Default
    private int topK = 40;

    /**
     * <b>TOP-P Sampling</b><br/>
     * Limit the next token selection to a subset of tokens with a cumulative probability above a threshold P
     * (default: 0.9).
     */
    @Builder.Default
    private float topP = 0.90f;

    /**
     * <b>Tail Free Sampling (TFS)</b><br/>
     * Enable tail free sampling with parameter z (default: 1.0, 1.0 = disabled).
     */
    @Builder.Default
    private float tsf = 1.0f;

    /**
     * <b>Typical Sampling</b><br/>
     * Enable typical sampling sampling with parameter p (default: 1.0, 1.0 = disabled).
     */
    @Builder.Default
    private float typical = 1.0f;

    /**
     * <b>Min P Sampling</b><br/>
     * Sets a minimum base probability threshold for token selection (default: 0.05).
     */
    @Builder.Default
    private float minP = 0.05f;

    /**
     * <b>Mirostat Sampling</b><br/>
     * Enable Mirostat sampling, controlling perplexity during text generation
     * (default: 0, 0 = disabled, 1 = Mirostat, 2 = Mirostat 2.0).
     */
    @Builder.Default
    private MirostatMode mirostatMode = MirostatMode.DISABLED;

    /**
     * <b>mirostat-lr</b><br/>
     * Set the Mirostat learning rate, parameter eta (default: 0.1).
     */
    @Builder.Default
    private float mirostatETA = 0.1f;

    /**
     * <b>mirostat-ent</b><br/>
     * Set the Mirostat target entropy, parameter tau (default: 5.0).
     */
    @Builder.Default
    private float mirostatTAU = 5.0f;

    /**
     * <b>grammars</b><br/>
     * Specify a grammar (defined inline or in a file) to constrain model output to a specific format.
     * For example, you could force the model to output JSON or to speak only in emojis
     */
    @Nullable
    private String grammarRules;

    /**
     * <b>max-new-tokens</b><br/>
     * Maximum new token generation size.
     */
    @Builder.Default
    private int maxNewTokenSize = 0;

    /**
     * <b>verbose prompt</b><br/>
     * Print the prompt before generating text.
     */
    @Builder.Default
    private boolean verbosePrompt = false;

    /**
     * <b>logits processor list</b><br/>
     */
    @Nullable
    private LogitsProcessorList logitsProcessorList;

    /**
     * <b>stopping criteria list</b><br/>
     */
    @Nullable
    private StoppingCriteriaList stoppingCriteriaList;

    /**
     * <b>user</b><br/>
     * Specify user nickname, default: User.
     */
    @Builder.Default
    private String user = "User";

    /**
     * <b>assistant</b><br/>
     * Specify bot nickname, default: Assistant.
     */
    @Builder.Default
    private String assistant = "Assistant";

    /**
     * NOTE: Reserved parameter, do not use it.
     */
    @Setter
    @Builder.Default
    private int lastTokensSize = 64;

    /**
     * Mirostat sampling mode define
     */
    public enum MirostatMode {
        DISABLED, V1, V2
    }

}
