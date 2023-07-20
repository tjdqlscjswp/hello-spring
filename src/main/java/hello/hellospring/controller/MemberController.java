package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    //스프링 컨테이너가 컨트롤러 어노테이션이 있으면 해당 멤버 컨트롤러 객체를 생성해서 스프링에 넣어둔다.
    //스프링 빈이 관리된다.
    private final MemberService memberService;

    @Autowired
    //AutoWired 스프링이 연결시켜준다. DI. 의존성 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}

//정리
//스프링 빈 등록 1. 컴포넌트 스캔과 자동 의존관계
//어노테이션 -> 컴포넌트 스캔. 컴포넌트 스캔은 같은 패키지 내에서, main 함수의 패키지 포함하는 파일들에서만 스캔
//스프링은 스프링 컨테이너에 스프링 빈을 등록할때 기본으로 싱글톤으로 등록한다. 즉 유일하게 하나만 등록해서 공유. 같은 스프링 빈이면 모두 같은 인스턴스
//2. 자바 코드로 직접 스프링 빈 등록


//컴포넌트 스캔을 사용하면 만일 상황에 따라 구현 클래스를 변경해야 할 때 어노테이션 변경 등 여러 군데에서 코드를 바꿔야 하는데
//config 사용해서 직접 스프링 빈 설정 시 설정 파일 내 해당 부분의 구현 클래스 이름만 변경해주면 된다.