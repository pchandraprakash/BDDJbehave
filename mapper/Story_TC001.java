package mapper;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

import steps.UiSteps;

public class Story_TC001 extends JUnitStories {

	public Story_TC001() {
		super();
		this.configuredEmbedder().candidateSteps().add(new UiSteps());
	}

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(getClass().getClassLoader()))
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withFormats(Format.CONSOLE, Format.STATS, Format.HTML));
	}

	@Override
	public List<CandidateSteps> candidateSteps() {
		return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
	}

	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("/jbehaveDemo/src/main/java/stories/Story_TC001.story");
	}

}
