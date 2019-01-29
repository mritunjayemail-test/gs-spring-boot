package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ground.example.Topic;

@RestController
public class HelloController {

	@Autowired
	private TopicService topics;

	@PutMapping("/update/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topics.updateTopic(id, topic);
	}

	@PostMapping("add")
	public void addTopic(@RequestBody Topic topic) {

		topics.add(topic);
	}

	@RequestMapping("/hello2/{name}")
	public Topic hello2(@PathVariable String name) {
		return topics.getTopic(name);
	}

	@RequestMapping("/hello1")
	public List<Topic> hello1() {
		return topics.getAllTopics();
	}

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/hello")
	public String hello() {
		return "Hello World !";
	}

}
