1. 什么时候需要加上@ResponseBody？
2. URL路径匹配：
    1. @RequestMapping(value = "/get/{id}.json")
    2. @RequestMapping(value = "/user/all/*.json"),Ant表达式
    3. @GetMapping("/${random}.json"),从配置文件中读取值
3. 请求参数转JavaBean，*多层级*
4. @ModelAttribute用于添加Controller中的公用方法，那能不能设置某个业务方法调用之前不调用这个方法呢？
5. *@initBinder*绑定请求参数到方法参数的转换器。
6. @Validated触发spring的校验。将校验结果放在BindingResult对象中。
7. *自定义校验*的使用，参见@WorkOverTime的实现，实现ConstraintValidator接口。
8. 实现WebMvcConfigurer定义*MVC全局配置*。如：拦截器配置，*跨域*配置。
9. 使用@Configuration以及@Bean进行配置，参见com.bee.sample.ch3.conf.JacksonConfig。
10. Redirect和Forward。
11. Controller中抛出的异常的处理。见ErrorController，默认映射在/error上。
12. @SessionAttribute、@RequestAttribute。

