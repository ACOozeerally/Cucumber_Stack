package com.ACO.Cucumber;

import java.util.Stack;

import static org.junit.Assert.*;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition {

	private myStack MyStack;
	private Object pushed;
	private Object popped;

	@Before
	public void setup() {
		MyStack = new myStack();
	}

	@Given("^an empty stack$")
	public void an_empty_stack() {
		Stack mystack = new Stack();
	}

	@When("^I push an item into the stack$")
	public void i_push_an_item_into_the_stack() {
		String item = "This is an item";
		MyStack.push(item);
	}

	@Then("^the stack contains one item$")
	public void the_stack_contains_one_item() {
		MyStack.size();
		assertEquals(1, MyStack.size());
	}

	@When("^I push another item into the stack$")
	public void i_push_another_item_into_the_stack() {
		String item2 = "This is an item";
		MyStack.push(item2);
	}

	@Then("^the stack contains two items$")
	public void the_stack_contains_two_items() {
		MyStack.size();
		assertEquals(2, MyStack.size());
	}

	@When("^I pop from the stack$")
	public void i_pop_from_the_stack() {
		MyStack.pop();
	}

	@Then("^I get the same item back$")
	public void i_get_the_same_item_back() {
		String item2 = "This is an item";
		MyStack.push(item2);
		assertEquals(item2, MyStack.pop());
	}

	@Given("^a stack with (\\d+) items$")
	public void a_stack_with_items(int arg1) {
		MyStack = new myStack();
		String item1 = "This is an item";
		String item2 = "This is an item";
		String item3 = "This is an item";
		MyStack.push(item1);
		MyStack.push(item2);
		MyStack.push(item3);
		assertEquals(item3, MyStack.pop());
	}
}
