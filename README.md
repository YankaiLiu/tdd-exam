# Locker Robot System Tasking

1. Given: S尺寸的包， 小樱， S型号的Lcoker还有空柜子； When 存包； Then: 存包成功，返回S型号票据

2. Given:  S尺寸的包， 小樱， S型号的Lcoker没有空柜子； When 存包； Then: 存包失败，提示柜子已满

3. Given:  M尺寸的包， 小樱，PrimaryLockerRobot，PrimaryLockerRobot 管理两个M型号的Locker, Lcoker都还有空柜子； When 存包； Then: 存包成功，且存在第一个柜子，返回M型号票据

4. Given:  M尺寸的包， 小樱，PrimaryLockerRobot，PrimaryLockerRobot 管理两个M型号的Locker, 第一个Locker已存满，第二个Locker还有位置； When 存包； Then: 存包成功，且存在第二个柜子，返回M型号票据

5. Given:  M尺寸的包， 小樱，PrimaryLocker Robot，PrimaryLockerRobot 管理两个M型号的Locker, 两个Locker都已存满； When 存包； Then: 存包失败，提示柜子已满

6. Given：L尺寸的包，小樱，SuperLockerRobot，SuperLockerRobot管理两个L型号的Locker，Lcoker都还有空柜子； When 存包； Then: 存包成功，存在空置率大的柜子，返回S型号票据
7. Given：L尺寸的包，小樱，SuperLockerRobot，SuperLockerRobot管理两个L型号的Locker，两个Locker都已存满； When 存包； Then: 存包失败，提示柜子已满
8. Given：有效的票据，小樱，小樱没有犯错，拿票据对应的型号的Locker或Manager取包；When：取包；Then：取包成功，回收票据
9. Given：有效的票据，小樱，小樱出错了，没有去票据对应型号的Locker取包；When：取包；Then：取包失败，提示票的型号不对
10. Given：无效的票据，小樱；When：取包；Then：取票失败，提示无效的票据。
11. Given：VIP顾客， S型号的包，LockerRobotManager，LockerRobotManager管理一个 Locker（S号）、一个PrimaryLockerRobot（M号）、一个SuperLockerRobot（L号），Locker还有空柜子； When： 存包；Then： 存包成功，返回S型号票据。
12. Given：VIP顾客， S型号的包，LockerRobotManager，LockerRobotManager管理一个 Locker（S号）、一个PrimaryLockerRobot（M号）、一个SuperLockerRobot（L号），Locker没有空柜子； When： 存包；Then： 存包失败，提示柜子已存满。
13. Given：VIP顾客， M型号的包，LockerRobotManager，LockerRobotManager管理一个 Locker（S号）、一个PrimaryLockerRobot（M号）、一个SuperLockerRobot（L号），PrimaryLockerRobot管理的Locker还有空柜子； When： 存包；Then： 存包成功，返回M型号票据。
14. Given：VIP顾客， M型号的包，LockerRobotManager，LockerRobotManager管理一个 Locker（S号）、一个PrimaryLockerRobot（M号）、一个SuperLockerRobot（L号），PrimaryLockerRobot管理的Locker没有空柜子； When： 存包；Then： 存包失败，提示柜子已存满。
15. Given：VIP顾客， L型号的包，LockerRobotManager，LockerRobotManager管理一个 Locker（S号）、一个PrimaryLockerRobot（M号）、一个SuperLockerRobot（L号），SuperLockerRobot管理的Locker还有空柜子； When： 存包；Then： 存包成功，返回M型号票据。
16. Given：VIP顾客， L型号的包，LockerRobotManager，LockerRobotManager管理一个 Locker（S号）、一个PrimaryLockerRobot（M号）、一个SuperLockerRobot（L号），SuperLockerRobot管理的Locker没有空柜子； When： 存包；Then： 存包失败，提示柜子已存满。
17. Given: 非VIP顾客，When: 存包；Then：存包失败，提示非VIP顾客
18.  Given：VIP顾客， 有效的票据，LockerRobotManager，去票据对应的型号的Locker取包；When：取包；Then：取包成功，回收票据
19. Given：VIP顾客，无效的票据，LockerRobotManager；When：取包；Then：取票失败，提示无效的票据。
20. Given: 非VIP顾客，When: 取包；Then：取包失败，提示非VIP顾客
21. Given超市管理员配置S类型的Locker到PrimaryLockerRobot; When 配置Robot；Then：提示Locker类型不对；
22. LockerRobotManager配置S类型的Locker到PrimaryLockerRobot; When 配置Robot；Then：提示Locker类型不对；







