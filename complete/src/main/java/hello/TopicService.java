package hello;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ground.example.Topic;

@Service
public class TopicService {

	private List<Topic> topics = Arrays.asList(new Topic("1", "Mritunjay"), new Topic("2", "Rakhi Prasad"));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String name) {
		return topics.stream().filter(t -> t.getName().equals(name)).findFirst().get();
	}

	public void add(Topic topic) {
		topics.add(topic);

	}
	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}
}
