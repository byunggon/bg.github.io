package com.kised.departments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsTreeDTO {
    private String id;     // 노드 ID (예: DEPT_10, EMP_101)
    private String parent; // 부모 ID (최상위는 "#")
    private String text;   // 화면에 표시될 이름
    private String icon;   // 아이콘 (선택사항)
}
