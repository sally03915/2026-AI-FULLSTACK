-- --------------------------------------------------------
-- --------------------------------------------------------
-- 복습문제1) 
-- +--------+------------+-------+-------+------+
-- | DEPTNO | DNAME      | EMPNO | ENAME | SAL  |
-- +--------+------------+-------+-------+------+
-- |     20 | RESEARCH   |  7566 | JONES | 2975 |
-- |     30 | SALES      |  7698 | BLAKE | 2850 |
-- |     10 | ACCOUNTING |  7782 | CLARK | 2450 |
-- |     20 | RESEARCH   |  7788 | SCOTT | 3000 |
-- |     10 | ACCOUNTING |  7839 | KING  | 5000 |
-- |     20 | RESEARCH   |  7902 | FORD  | 3000 |
-- +--------+------------+-------+-------+------+
-- 6 rows in set (0.00 sec)

-- -- emp ,DEPT 테이블에서  급여가 2000  초과인 사원들의 부서 정보, 사원정보를 다음과 같이   조회하시오.
-- join 4가지 방법을 이용해서 조회하시오.

select  d.DEPTNO , DNAME  , EMPNO, ENAME, SAL
from    emp e, dept d
where   d.deptno = e.deptno   and  sal > 2000;

select  d.DEPTNO , DNAME  , EMPNO, ENAME, SAL
from    emp e  join  dept d  on d.deptno = e.deptno   
where   sal > 2000;

select  d.DEPTNO , DNAME  , EMPNO, ENAME, SAL
from    emp e  join  dept d   using(deptno)   
where   sal > 2000;

select  DEPTNO , DNAME  , EMPNO, ENAME, SAL
from    emp e  natural join  dept d  
where   sal > 2000;





-- --------------------------------------------------------
-- --------------------------------------------------------
-- 복습문제2) 
-- -- emp ,DEPT 테이블에서  각 부서별 평균급여, 최대급여, 최소급여, 사원수를  다음과 같이   조회하시오.
-- -- = 등가조인을 이용하시오.
-- join 4가지 방법을 이용해서 조회하시오.
-- +--------+------------+-----------+---------+---------+-----+
-- | DEPTNO | DNAME      | AVG_SAL   | MAX_SAL | MIN_SAL | CNT |
-- +--------+------------+-----------+---------+---------+-----+
-- |     10 | ACCOUNTING | 2916.6667 |    5000 |    1300 |   3 |
-- |     20 | RESEARCH   | 2175.0000 |    3000 |     800 |   5 |
-- |     30 | SALES      | 1566.6667 |    2850 |     950 |   6 |
-- +--------+------------+-----------+---------+---------+-----+
-- 3 rows in set (0.00 sec)
select    d.DEPTNO , DNAME   , avg(sal) `AVG_SAL`, max(sal) `MAX_SAL` , min(sal) `MIN_SAL` , count(*) `CNT`
from      emp  e , DEPT  d
where     e.deptno = d.deptno
group by  d.DEPTNO , DNAME
order by  d.deptno asc;
 
select    d.DEPTNO , DNAME   , avg(sal) `AVG_SAL`, max(sal) `MAX_SAL` , min(sal) `MIN_SAL` , count(*) `CNT`
from      emp  e join DEPT  d   on  e.deptno = d.deptno
group by  d.DEPTNO , DNAME
order by  d.deptno asc;
 
select    d.DEPTNO , DNAME   , avg(sal) `AVG_SAL`, max(sal) `MAX_SAL` , min(sal) `MIN_SAL` , count(*) `CNT`
from      emp  e join DEPT  d   using(deptno)
group by  d.DEPTNO , DNAME
order by  d.deptno asc; 

select    DEPTNO , DNAME   , avg(sal) `AVG_SAL`, max(sal) `MAX_SAL` , min(sal) `MIN_SAL` , count(*) `CNT`
from      emp  e  natural join DEPT  d  
group by  DEPTNO , DNAME
order by  deptno asc; 





-- --------------------------------------------------------
-- --------------------------------------------------------
-- 복습문제3) 
-- -- emp ,DEPT 테이블에서 모든부서정보와 사원정보를 다음과 같이 부서번호, 사원이름 순으로    조회하시오.
-- -- left , right join을 이용하시오.
-- +--------+------------+-------+--------+-----------+------+
-- | DEPTNO | DNAME      | EMPNO | ENAME  | JOB       | SAL  |
-- +--------+------------+-------+--------+-----------+------+
-- |     10 | ACCOUNTING |  7782 | CLARK  | MANAGER   | 2450 |
-- |     10 | ACCOUNTING |  7839 | KING   | PRESIDENT | 5000 |
-- |     10 | ACCOUNTING |  7934 | MILLER | CLERK     | 1300 |
-- |     20 | RESEARCH   |  7876 | ADAMS  | CLERK     | 1100 |
-- |     20 | RESEARCH   |  7902 | FORD   | ANALYST   | 3000 |
-- |     20 | RESEARCH   |  7566 | JONES  | MANAGER   | 2975 |
-- |     20 | RESEARCH   |  7788 | SCOTT  | ANALYST   | 3000 |
-- |     20 | RESEARCH   |  7369 | SMITH  | CLERK     |  800 |
-- |     30 | SALES      |  7499 | ALLEN  | SALESMAN  | 1600 |
-- |     30 | SALES      |  7698 | BLAKE  | MANAGER   | 2850 |
-- |     30 | SALES      |  7900 | JAMES  | CLERK     |  950 |
-- |     30 | SALES      |  7654 | MARTIN | SALESMAN  | 1250 |
-- |     30 | SALES      |  7844 | TURNER | SALESMAN  | 1500 |
-- |     30 | SALES      |  7521 | WARD   | SALESMAN  | 1250 |
-- |     40 | OPERATIONS |  NULL | NULL   | NULL      | NULL |
-- +--------+------------+-------+--------+-----------+------+
-- 15 rows in set (0.00 sec)


select    d.DEPTNO , DNAME    , EMPNO , ENAME ,JOB  , SAL  
from      dept d  left join emp  e    on   d.deptno = e.deptno
order  by  d.deptno, ename;

select    d.DEPTNO , DNAME    , EMPNO , ENAME ,JOB  , SAL  
from      emp  e     right join  dept d    on   d.deptno = e.deptno
order  by  d.deptno, ename;


