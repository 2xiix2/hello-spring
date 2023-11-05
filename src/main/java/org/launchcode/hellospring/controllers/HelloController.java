package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller //by default this controller has no routing info assoc. with it (it will live at the ROOT path)
public class HelloController {
    //Handles request at path /hello put "hello" as a parameter at @GetMapping
//    @GetMapping("hello") <--- To handle get request (this method will only handle GET Request)
//    @ResponseBody //returns a plain text response (until we learn templates)
//    public String hello() {
//        return "Hello, Spring!";
//    }


    @GetMapping("goodbye") //To handle get request (this method will only handle GET Request)
    @ResponseBody //returns a plain text response (until we learn templates)
    public String goodbye() {
        return "Goodbye, Spring.";
    }

    //Create a handler that handles request of the form /hello?name=LaunchCode
    //DYNAMIC HANDLER
//    @GetMapping("hello")
//    @ResponseBody
//    // @RequestParam annotation flags this as a "special method parameter" to Spring Boot
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!"; //This makes this a dynamic response
//    }
    /* NOTE:
     IN THE QUERY: "/hello?name=LaunchCode" whatever is put after the name=... will be the VALUE of the KEY (name in this case)
     For instance, it could go as: /hello?name=Bobby ..... the response would be: "Hello, Bobby!" and so on
    */

    //A handler that handles requests of the form /hello/LaunchCode <--- ("LaunchCode" is now a part of the PATH and NOT the query string)
    // THE VARIABLE IS PART OF THE PATH EXAMPLE BELOW:
//    @GetMapping("hello/{name}") // {name} <--- is call a PATH PARAMETER --->  Gets a piece of data in the path
//    @ResponseBody
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }
    //This all takes a request that contains some type of data and then creates returns a response based on that specific piece of data

//    @GetMapping("form")
//    @ResponseBody
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form action= 'hello'>" + // <--- this tells it to submit a request to "/hello"
//                "<input type= 'text' name= 'name'>" + //<--- already has a handler method that dynamically creates request with the query parameter called "name"
//                "<input type= 'submit' value= 'Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! //
    //Submit a form via a POST Request

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    // @RequestParam annotation flags this as a "special method parameter" to Spring Boot
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!"; //This makes this a dynamic response
    }

    @GetMapping("hello/{name}") // {name} <--- is call a PATH PARAMETER --->  Gets a piece of data in the path
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action= 'hello' method= 'post'>" + // <--- this tells it to submit a request to "/hello"
                "<input type='text' name='name'>" + //<--- already has a handler method that dynamically creates request with the query parameter called "name"
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }



}
